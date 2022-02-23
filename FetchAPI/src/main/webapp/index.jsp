<html>
<style>
     {
        font-family: Arial, Helvetica, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

     td,  th {
        border: 1px solid #ddd;
        padding: 8px;
    }

     tr:nth-child(even){background-color: #f2f2f2;}

     tr:hover {background-color: #ddd;}

    th {
        padding-top: 12px;
        padding-bottom: 12px;
        text-align: left;
        background-color: #04AA6D;
        color: white;
    }
</style>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="fetch.js"></script>
<button id="data">GetData</button>
<table>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <tbody id="tbody">
    </tbody>
</table>
</body>
</html>
