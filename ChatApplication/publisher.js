/**
 * Created by Yashas on 4/12/2016.
 */
var rest_url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20local.search(0%2C40)%20" +
    "where%20city%3D'SanFrancisco'%20and%20query%3D'restaurant'%20" +
    "and%20state%3D'CA'%7Csort(field%3D'Rating.AverageRating')%7Creverse()&format=json&diagnostics=true&callback=";
var news_url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20rss%20" +
    "where%20url%3D%22http%3A%2F%2Frss.news.yahoo.com%2Frss%2Ftopstories%22%7C" +
    "sort(field%3D%22pubDate%22)%7Creverse()&format=json&diagnostics=true&callback=";
var CHANN1 = "NeverBored!";
var CHANN2 = "NeverBored-News";
var CHANN = "chat-away";
occupants = 0;
var UUID = PUBNUB.db.get('session') || (function(){
        var uuid = PUBNUB.uuid();
        PUBNUB.db.set('session', uuid);
        return uuid;
    })();
var pubnub = PUBNUB.init({
    publish_key: 'pub-c-b4c017e9-2c8c-48aa-8bc1-384edbff3428',
    subscribe_key: 'sub-c-c882d2f4-fdc1-11e5-ba5f-0619f8945a4f',
    uuid:UUID
});

setInterval(function() {
    pubnub.here_now({
        channel: 'NeverBored!',
        callback: function (message) {
            console.log(message)
            if (message.occupancy != occupants) {
                occupants=message.occupancy;
                console.log(occupants);
                getNewsAndRestData();
            }
        }
    });
}, 5000);

var getJSON = function(url) {
    return new Promise(function(resolve, reject) {
        var xhr = new XMLHttpRequest();
        xhr.open('get', url, true);
        xhr.responseType = 'json';
        xhr.onload = function() {
            var status = xhr.status;
            if (status == 200) {
                resolve(xhr.response);
            } else {
                reject(status);
            }
        };
        xhr.send();
    });
};


var sendjsonData = function(data)
{

    var items = data.query.results.Result;
    var no_items=items.length;
    restContent.innerHTML="";
    restContent.innerHTML = "<span style='font-size: x-large;color: black;font-weight: bolder'>Top " +
        "40 Restaurants in San Francisco!</span><br/>";
    for(var i=0;i<no_items;i++){
        var rest_data={}
        rest_data.title = items[i].Title;
        rest_data.link = items[i].Url;
        rest_data.phone = items[i].Phone;
        if(isNaN(items[i].Rating.AverageRating))
        {
            rest_data.rating = "Rating Not Available";
        }
        else rest_data.rating = items[i].Rating.AverageRating;


        pubnub.publish({
            channel:CHANN1,
            message:rest_data,
            error: function(err){console.log(JSON.stringify(err))}});

        restContent.innerHTML = restContent.innerHTML + "<h3><a style='color: crimson' href='" + items[i].Url + "'>"+items[i].Title
            +"</a></h3>" + "Rating: " + items[i].Rating.AverageRating + "<br>" + "Phone Number: " + "<span style='color: midnightblue'>"
            +items[i].Phone + "</span>"+"<hr/>";


    }
}

var sendnewsjsonData = function (data) {
    var items = data.query.results.item;
    var no_items=items.length;
    newsContent.innerHTML = "";
    newsContent.innerHTML = "<span style='font-size: x-large;color: black;font-weight: bolder'>Breaking " +
        "News</span><br/>";
    for(var i=0;i<no_items;i++){
        var news_data={}
        news_data.title = items[i].title;
        news_data.link = items[i].link;
        news_data.desc = items[i].description;

        pubnub.publish({
            channel:CHANN2,
            message:news_data,
            error: function(err){console.log(JSON.stringify(err))}});

        newsContent.innerHTML = newsContent.innerHTML + "<h3><a href='" + items[i].link + "'>"+items[i].title
            +"</a></h3>" + items[i].description + "<hr/>";
    }

}




var setChat = function(){
    var outputChatText = pubnub.$('chatBox'), chat = pubnub.$('chatInput');
    pubnub.subscribe({
        channel  : CHANN,
        callback : function(text) {
            outputChatText.innerHTML = outputChatText.innerHTML + "<br/>"
            +(''+text).replace( /[<>]/g, '' )},
        error: function(err){console.log(err)}
    });
    pubnub.bind( 'keyup', chat, function(e) {
        (e.keyCode || e.charCode) === 13 && pubnub.publish({
            channel : CHANN,
            message : chat.value,
            x : (chat.value='')
        })
    })
};

var getNewsAndRestDataAndSetChat = function(){
    setChat();
    getNewsAndRestData();
}



var getNewsAndRestData = function(){
    console.log("im here");

    getJSON(rest_url).then(function(data) {
        console.log(data);
        sendjsonData(data);
    }, function(status) { //error detection....
        alert('Something went wrong.');
    });
    getJSON(news_url).then(function(data) {
        console.log(data);
        sendnewsjsonData(data);
    }, function(status) { //error detection....
        alert('Something went wrong.');
    });
}
