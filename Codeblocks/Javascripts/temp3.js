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
    //console.log(prev.id);
}
