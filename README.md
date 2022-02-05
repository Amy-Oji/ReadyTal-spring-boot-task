# Blog Engine powered by Spring Boot

## Introduction
This project is a simple REST application for serving a blog. It uses Spring Boot, Spring Data JPA and some other helper libraries.

## Problem Statement
Currently, application can only serve blog post details by executing GET request at `/posts/{id}`, where `{id}` is a post identifier.

Your task is to add comments feature. The application should be able to serve two new kinds of requests:

    POST at /posts/{1}/comments - which should save a new comment for post with passed {id} or return 404 Not Found if post doesn't exist
    GET at /posts/{1}/comments - which should return all comments for a post with passed {id}

There is a service class `CommentService` that you should implement. See contents of that class to see detailed requirements. For each method, there is a javadoc comment that describes expected behavior.

There are some tests that are currently failing and your solution should satisfy these tests requirements.
Remember that provided tests verify the functional correctness, however, you should remember to fulfill all best practices as well.

## Hints
Feel free to create new and modify existing files. You can add some new dependencies if you will, to do so just modify appropriate `pom.xml`. **Do not change unit tests**, however.

Please follow conventions used in this project.

### Good Luck!
