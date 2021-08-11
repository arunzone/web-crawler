# Web crawler application

## Design thoughts

### Strategy and development
I believe in TDD, and it helps me to design the system better. I tried to start creating small building block and separation of concern is followed by
assigning single responsibility to an object or function. The controller delegates the request to service which talk to `WebCrawlerService` to crawl given page.
Validation is baked in controller `@RequestParam`
Response contains word and its count.

### Assumptions and tradeoffs
Error handling and error response are not done to keep it simple
Progress bar not implemented on ui while waiting for response
This is the first time I used vue.js bare with me for any immaturity in coding

## Pre-requisite

2. Java11
3. npm or yarn

## Run the application

### Backend
1. Clone the provided repo
2. Import the spring boot project to your IDE(Optional).
3. Run the project backend with IDE or `./gradlew bootrun`

### UI
```
cd frontend
yarn run serve
```
Navigate to http://localhost:8081/ in browser
Enter url and word corresponding textbox
And click on search button
Result will be displaying below the search button

### Test
`./gradlew test`
When it comes to TDD I always try to start with Unit, integration and build the way up to end-to-end test.

```
cd frontend
yarn run test:unit
```

