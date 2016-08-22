/**
 * Created by Yashas on 4/13/2016.
 */

var initialize = function() {

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


    pubnub.subscribe({
        channel: 'chat-away',

        callback: function (text) {
            chatBox.innerHTML = chatBox.innerHTML + "<br/>"
                + ('' + text).replace(/[<>]/g, '')
        },
        error: function (err) {
            console.log(err)
        }
    });
    pubnub.bind('keyup', chatInput , function (e) {
        (e.keyCode || e.charCode) === 13 && publish()});

    var publish = function() {
        pubnub.publish({
            channel: 'chat-away',
            message: document.getElementById('chatInput').value,
            callback: function (msg) {
                console.log(msg);
            },
            error: function(msg){console.log(msg);},
            x: (document.getElementById('chatInput').value = '')
        })
    };
    restContent.innerHTML = "<span style='font-size: x-large;color: black;font-weight: bolder'>Top " +
        "40 Restaurants in San Francisco!</span><br/>";
    newsContent.innerHTML = "<span style='font-size: x-large;color: black;font-weight: bolder'>Breaking " +
        "News</span><br/>";

    var UUID = PUBNUB.db.get('session') || (function(){
            var uuid = PUBNUB.uuid();
            PUBNUB.db.set('session', uuid);
            return uuid;
        })();

    PUBNUB.init({
        subscribe_key: 'sub-c-c882d2f4-fdc1-11e5-ba5f-0619f8945a4f',
        uuid: UUID
    }).subscribe({
        channel: 'NeverBored!,NeverBored-News',

        message: function (msg, env, ch) {
            console.log("Channel is" + ch);

            if (ch === "NeverBored!") {
                if (restContent.innerHTML.indexOf(msg.title) === -1) {
                    restContent.innerHTML = restContent.innerHTML + "<h3><a style='color: crimson' href='" + msg.link + "'>" + msg.title
                        + "</a></h3>" + "Rating: " + msg.rating + "<br>" + "Phone Number: " + "<span style='color: midnightblue'>"
                        + msg.phone + "</span>" + "<hr/>"
                }
            }
            else if (ch === "NeverBored-News") {
                if (newsContent.innerHTML.indexOf(msg.title) === -1) {
                    newsContent.innerHTML = newsContent.innerHTML + "<h3><a href='" + msg.link + "'>" + msg.title
                        + "</a></h3>" + msg.desc + "<hr/>"
                }
            }
        },
        error: function (err) {
            console.log(err)
        },
        presence : function(msg){console.log(msg.occupancy)}
    });
};