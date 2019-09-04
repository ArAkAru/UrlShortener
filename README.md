# UrlShortener
We use hashmap as a database where we write the key and value. The key is the unique identifier of the entry, the value will be the original URL.
To ensure the uniqueness of the short link, we will use a unique identifier, for example, the number of the record in the database. In our case, this is a random integer field that is used to convert the original link to a shortened link.
The reverse process is to get an integer (our identifier) ​​from the shortened URL and search for that identifier in the hash map to get the original link.
![alt text](https://hackernoon.com/hn-images/1*zkdmskLWL8qj76A2rHWgDA.png)
