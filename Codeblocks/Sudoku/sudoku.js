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
        create_board(data);
        console.log(data);
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });

function create_board(board)
{
  var txt='';
  board['board'].forEach(function(value){
    value.forEach(function(value){
      txt = txt + value + "  "; 
    });
    txt = txt + "<br>";
  });
  document.getElementById('sudoku_board').innerHTML = txt;
}