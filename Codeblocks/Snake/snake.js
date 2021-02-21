
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
        speed: 50,
    }

    main_canvas = document.getElementById("main_canvas");
    main_canvas.width = canvas.w;
    main_canvas.height = canvas.h;
    //main_canvas.margin = canvas.margin;
    //main_canvas.border = canvas.border;
    
    snake = {
        cells: [],
        direction: 'right',
        initial_size: 5,
        cs: 100,    // single cell size
        x: canvas.position.start.x,
        y: canvas.position.start.y,

        create:function(){
            for(var i=0; i<this.initial_size; i++)
            {
                this.cells.push({x: canvas.position.start.x+i, y: canvas.position.start.y});
            }
        },
        draw:function(){
            for(var i=0; i<this.cells.length; i++)
            {
                pen.fillRect(this.cells[i].x+this.cs, this.cells[i].y+this.cs, this.cs-2, this.cs-2);
            }
        },
        update:function(){
            var headX = this.cells[this.cells.length-1].x;
            var headY = this.cells[this.cells.length-1].y;
            var X = headX;
            var Y = headY;
            var cons = game.speed;//1;//this.cs;
            this.cells.shift();
            if(this.direction=='right')
            {
                X = headX + cons;
            }
            else if(this.direction=='left')
            {
                X = headX - cons;
            }
            else if(this.direction=='up')
            {
                Y = headY + cons;
            }
            else if(this.direction=='down')
            {
                Y = headY - cons;
            }
            this.cells.push({x:X, y:Y});
        }
    }
    
    pen = main_canvas.getContext('2d');
    pen.fillStyle = "red";
    snake.create();
    snake.draw();
}
function draw()
{
    pen.clearRect(0, 0, canvas.w, canvas.h);
    snake.draw();
}
function update()
{
    console.log(snake.cells);
    if(snake.cells[snake.cells.length-1].x+snake.cs>=canvas.w)
        snake.direction = 'left';
    
    if(snake.cells[snake.cells.length-1].x-snake.cs<=canvas.position.start.x)
        snake.direction = 'right';

    //if(snake.cells[snake.cells.length-1].y+snake.cs>canvas.h)
        //snake.direction = 'up';
    
    //if(snake.cells[0].y<=canvas.position.start.y)
        //snake.direction = 'down';

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

    function keyPressed(e)
    {
        //console.log(e.key);
        snake.direction = e.key.substring(5, e.key.length).toLowerCase();
        //console.log(snake.direction);
    }
    xyz=document.addEventListener('keydown', keyPressed);
}
function stop()
{
    clearInterval(game.session);
}
init();
start();