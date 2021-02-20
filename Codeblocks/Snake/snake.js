
function init()
{
    canvas = {
        position : {
            start: {
                x: 1,
                y: 1,
            },
        },
        w: 2500,
        h: 2500,
        margin: '10px',
        border: '1px solid black',
    }

    game = {
        status : 'start',
        session: '',
        speed: 10,
    }

    main_canvas = document.getElementById("main_canvas");
    main_canvas.width = canvas.w;
    main_canvas.height = canvas.h;
    //main_canvas.margin = canvas.margin;
    //main_canvas.border = canvas.border;
    
    snake = {
        cells: [],
        direction: 1,
        initial_size: 5,
        cs: 100,    // single cell size
        x: canvas.position.start.x,
        y: canvas.position.start.y,

        create:function(){
            for(var i=0; i<this.initial_size; i++)
            {
                this.cells.push({x: canvas.position.start.x+this.cs*i, y: canvas.position.start.y});
            }
        },
        draw:function(){
            for(var i=0; i<this.cells.length; i++)
            {
                pen.fillRect(this.cells[i].x, this.cells[i].y, this.cs, this.cs);
            }
        },
        update:function(){
            //initial_x = this.cells[0].x;
            initial_y = this.cells[0].y;
            for(var i=0; i<this.cells.length; i++)
            {
                //pen.clearRect(this.cells[i].x, this.cells[i].y, snake.cs, snake.cs);
                this.cells[i]=({x: (this.cells[i].x+game.speed*this.direction), y:(initial_y)});
            }
        }
    }
    
    pen = main_canvas.getContext('2d');
    pen.fillStyle = "red";
    snake.create();
    snake.draw();
}
function draw()
{
    snake.draw();
}
function update()
{
    //if(snake.cells[snake.cells.length-1].x>canvas.w)
      //  snake.direction = -1;
    
    //if(snake.cells[0].x<canvas.position.start)
      //  snake.direction = 1;

    snake.update();
}
function gameloop()
{
    draw();
    update();
}
function start()
{
    game.session = setInterval(gameloop, 100);
}
function stop()
{
    clearInterval(game.session);
}
init();
start();