package com.example.moviesapp.network

/**
 * The `NetworkConstants` object contains constant values related to network requests, including authorization and accept headers.
 */
object NetworkConstants {
    /**
     * The `authorization` constant represents the authorization header required for making authenticated API requests.
     * It contains an access token (Bearer token) used to authenticate and authorize the application to access protected resources.
     */
    const val authorization =
        "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4ZGMzM2JhYjBhMGFjMmMyZDYyM2MxZGY5NTA0NzQ2MSIsInN1YiI6IjY0ZTA4YTA1Yjc3ZDRiMTEzZTA3NGU1MiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.F6M-8SIhRDGqUrJPXDIUzfnpazufaTHLSqSKSZAHx3w"

    /**
     * The `accept` constant represents the accept header for specifying the expected response format as JSON.
     * It indicates that the application expects the API to respond with data in JSON format.
     */
    const val accept = "accept: application/json"
}