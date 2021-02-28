function permutation_generator(value)
{
    answerr=document.getElementById('answer');
    var arr=value.split('');
    answer={
        list:''
    }
    answer_generator(answer, 0, arr, '');
    answerr.innerHTML = answer.list;
}
function answer_generator(answer, index, arr, ans_string)
{
    if(ans_string.length==arr.length)
    {
        answer.list=answer.list+(ans_string+"<br>");
        return;
    }
    for(var i=index; i<arr.length; i++)
    {
        swap(arr, i, index);
        answer_generator(answer, index+1, arr, ans_string+arr[index]);
        swap(arr, i, index);
    }
}
function swap(arr, i, j)
{
    var temp=arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
}

function dropdown(value)
{
    document.getElementById('string_permutation').style.display='none';
    document.getElementById('n_queen').style.display='none';
    document.getElementById(value).style.display='block';
}
function n_queen(value)
{
    create_board(value);
}
function create_board(value)
{
    var board = "<table class='center' style='border:5px solid black; border-collapse: collapse;'>";
    var xyz="black";
    for(var i=1; i<=value; i++)
    {
        board = board + "<tr>";
        for(var j=1; j<=value; j++)
        {
            if(xyz=='black')
            xyz='beige';
            else
            xyz='black';
            board = board +"<td style='width:50px; height:50px; background-color:"+xyz+"'</td>";
        }
        board = board +"</tr>";

        if(value%2==0)
        if(xyz=='black')
        xyz='beige';
        else
        xyz='black';
    }
    board=board+"</table>";
    document.getElementById('answer_board').innerHTML = board;
}