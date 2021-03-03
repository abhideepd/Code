function main(board_size)
{
    create_board(board_size);
}
function keypress(event) 
{
    if((event.key=="ArrowRight")||(event.key=="ArrowLeft"))
    {
        create_board(document.getElementById('input_puzzle_boardsize').value);
    }
}
function set_board_style(board, val)
{
    var last_box = "#"+val+"{display:none;}";
    var other_styles = ".cells{width:50px; height:50px; padding:2px; margin:2px; font-size:20px; font-weight:bold;}.row{text-align:left}.board, .puzzle_board{text-align:center; margin:50px;}";
    //var other_styles = "";
    var style = "<style>" + other_styles + last_box + "</style>";
    //var style = "";
    board_id = document.getElementById('puzzle');
    board = style + board;
    board_id.innerHTML = board;
}
function cell_shift(id, value)
{
    console.log("current cell: "+id+" "+value);
}
function getrowid(id)
{
    console.log("current div: "+id);
}
function create_board(board_size)
{
    var val = board_size;
    board_id = document.getElementById('puzzle');
    var board = "<div id='puzzle_board' class='puzzle_board'>";
    //var board = "";
    var cell_no = 0;
    var random_no_list = [cell_no];
    for( var i=1; i<=val; i++)
    {
        board = board + "<div id = 'row_"+i+"' class='row' onclick='getrowid(this.id)'>";
        for(var j=1; j<=val; j++)
        {
            //console.log(cell_no);
            while(random_no_list.findIndex( func = (val) => val==cell_no)!=-1)
            {
                cell_no = generate_random_nos(board_size*board_size);
                //console.log(cell_no);
            }
            random_no_list.push(cell_no);
            board = board + "<input type = button class='cells' id='cell_"+cell_no+"' value='"+cell_no+"' onclick='cell_shift(this.id, this.value)'/>";
            //++cell_no;
        }
        board = board + "</div>";
    }
    val = val * val;
    val = "cell_"+val;
    set_board_style(board, val);
}
function generate_random_nos(b)
{
    //b = b - 1;
    var x = Math.floor((Math.random() * b) + 1);
    return x;
}
main(4);