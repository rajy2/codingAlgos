Out of my personal experience and of my friends we have sometime or the other wondered what to chat with someone but have no common topics as such, we have also tried finding best
restaurants in our city but everytime we find something we need to tell the other people to check for the restaurant on google/share the link or so on. With the help of the application
I have developed and with the awesome features provided by PubNub there is no need to share or think about a topic to discuss. What better than discussing and venting out your opinion about
a breaking news to your friends such that you can continue your discussion as your friend will also be able to access the news right away! OR WHat better than viewing top 40 restaurants on
your's and your buddies screen and choosing which amazing restaurant you wanna dine in to fulfill your growling tummy without having to share links or share a 100 messages just discussing
which restaurant you are actually referring to! The wait is over! Follow the below steps and give way to a whole screen of yummy munches and hot and latest news through PubNub!

Setting up the Awesome Webpage!

Step 1: Download the "subscriber.html" file, "subscriber.js" file and very important to render the beautiful page! the "styleInfo.css" file. 
Step 2: For publishing the application, please download the "publisher.html" and "publisher.js" files. The styling for the publisher is provided by "styleInfo.css" itself. 
The project is now setup for use.

Steps to run the application:

Run "publisher.html" and then the "subscriber.html". The data is automatically loaded to "subscriber.html" page with the help of presence and callback of here-now. That's it. Every feature
of the application, the top 40 restaurants in San Francisco, the latest news and chatting feature is available now.

Update on the application: The updates I would love to add are adding a button for the user to select which city's top 40 restaurants he/she would want to view. The other update is
improvising the chat feature by providing a better chat window and displaying users online, etc. 


Note: I have provided my publish and subscribe key for the chat application such that the publisher and the subscriber have the same keys. I tried publishing with a different set of 
publisher/subsciber keys to the channel but although the callback method displayed the Message sent on the console,the message was not displayed to others subscribed to the channel. As far
as I understand the publisher is required to give the subscribe-key for the channel which I have done for the News and Restaurant data but when it comes to chat feature I need to provide
the publish-key as well as I need to publish the message. As I needed to subscibe to the channel using the publisher's subscribe key and also provide a valid publisher/subscriber key set
I provided the publisher's keys itself. I know that this would not work in the real world and would love to learn to go about solving the issue.