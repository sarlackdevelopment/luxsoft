<#import "parts/common.ftl" as c>

<@c.page>
    <h1>"Hello! I love you! Would you take me your file?" (c)<h1>
</@c.page>
<div class="container mt-5">
    <form method="post" enctype="multipart/form-data">
        <input type="file" name="file" accept="text/plain">
        <button class="btn btn-primary" type="submit">Add file</button>
    </form>
</div>