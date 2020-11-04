<html>
<head>
    <title>Share movie</title>
</head>
<body>
<h1>Share movie</h1>
<form action="/share-movie/share" method="POST" enctype="utf8">
    <div>
        <label>Youtube URL: </label>
        <input id="youtubeUrl" name="youtubeUrl"/>
    </div>
    <div>
        <label>Title: </label>
        <input id="title" name="title" type="text"/>
    </div>
    <div>
        <label>Description: </label>
        <textarea id="description" name="description"></textarea>
    </div>
    <button type="submit">Share</button>
</form>
</body>
</html>
