function generate_board()
{
fetch('https://sugoku.herokuapp.com/board?difficulty=easy')
  .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Looks like there was a problem. Status Code: ' +
          response.status);
        return;
      }

      // Examine the text in the response
      response.json().then(function(data) {
        sudoku(data);
        board.create();
        //console.log(data);
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });
}

function sudoku(BD)
{
  board = {
    board_data : BD['board'],
    create:function(){
      var txt = '';
      var temp= '';
      var i1=0;
      var i2=0;
      var column_separator = "<span class='column_separator'></span>";
      var row_separator = "<div class='separator'></div>";
      var user_input = "<input type='number'>";
      var pre_defined_1 = "<input type='number' value=";
      var pre_defined_2 = " disabled/>";
      this.board_data.forEach(function(value){
        value.forEach(function(value){
          i1 = i1 + 1;
          if(value==0)
            temp = temp + user_input; 
          else
            temp = temp + pre_defined_1 + value + pre_defined_2;
          if(i1%3==0)
            temp = temp + column_separator;
        });
        i2 = i2 + 1;
        temp = "<div class='row'>" + temp + "</div>"
        txt = txt + temp;
        if(i2%3==0)
          txt = txt + row_separator;
        temp = "";
      });
      document.getElementById('sudoku_board').innerHTML = txt;
    },
    solve:function(){
      alert("FUCK YOU BITCH");
    },
  }
}
function refresh()
{
  board.create();
}
generate_board();
