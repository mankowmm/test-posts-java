For POST methods set header:

Content-Type: application/json

Available methods:

--------------------------------------------------------------------------
Send new post message:

POST: http://localhost:8080/sendPost

RAW POST data (as JSON)
{
	"message": "Some Post message 1",
	"author": "mankowmm"
}

--------------------------------------------------------------------------
Follow author:

POST: http://localhost:8080/followAuthor

RAW POST data (as JSON)
{
	"requestor": "mankowmm",
	"authorToFollow": "mankowmm1"
}

--------------------------------------------------------------------------
Get author posts:

GET: http://localhost:8080/getAuthorPosts?author=mankowmm


--------------------------------------------------------------------------
Get all posts (author + posts from followed users):

GET: http://localhost:8080/getAllPosts?author=mankowmm
