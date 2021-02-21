
function init()
{
    canvas = {
        position : {
            start: {
                x: 1,
                y: 1,
            },
            end:{
                x: 0,
                y: 0,
            },
        },
        w: 2500,
        h: 2500,
        margin: '10px',
        border: '10px solid blue',
    }

    game = {
        status : 'start',
        session: '',
        speed: 120,
    }

    canvas.position.end.x = 2500;
    canvas.position.end.y = 2500;
    main_canvas = document.getElementById("main_canvas");
    main_canvas.width = canvas.w;
    main_canvas.height = canvas.h;
    main_canvas.style.margin = canvas.margin;
    main_canvas.style.border = canvas.border;
    snakke_cell_size = 100;

    food={
        x:0,
        y:0,
        getRandom:function(){
            this.x=Math.round(Math.random()*(canvas.w-snakke_cell_size)/snakke_cell_size);
            this.y=Math.round(Math.random()*(canvas.w-snakke_cell_size)/snakke_cell_size);
        },
        draw:function(){
            pen.fillRect(this.x, this.y, snakke_cell_size-2, snakke_cell_size-2);
        },
    }
    
    snake = {
        cells: [],
        direction: 'right',
        initial_size: 5,
        head:{
            x:canvas.position.start.x+1,
            y:canvas.position.start.y+1,
        },
        cs: snakke_cell_size,    // single cell size
        x: canvas.position.start.x,
        y: canvas.position.start.y,

        create:function(){
            for(var i=0; i<this.initial_size; i++)
            {
                this.cells.push({x: i*this.cs, y: canvas.position.start.y});
            }
        },
        draw:function(){
            for(var i=0; i<this.cells.length; i++)
            {
                pen.fillRect(this.cells[i].x, this.cells[i].y, this.cs-2, this.cs-2);
            }
        },
        update:function(){

            var cons = this.cs;
            var headX = this.cells[this.cells.length-1].x;
            var headY = this.cells[this.cells.length-1].y;
            var X = headX;
            var Y = headY;
            this.cells.shift();
            
            if(this.direction=='right')
            {
                X = X + cons;

                //console.log("update:function() -- 'right'");
                //console.log(this.cells);
            }
            else if(this.direction=='left')
            {
                X = X - cons;

                //console.log("update:function() -- 'left'");
                //console.log(this.cells);
            }
            else if(this.direction=='down')
            {
                Y = Y + cons;
                
                //console.log("update:function() -- 'down'");
                //console.log(this.cells);
            }
            else if(this.direction=='up')
            {
                Y = Y - cons;

                //console.log("update:function() -- 'up'");
                //console.log(this.cells);
            }
            if((X==food.x)&&(Y==food.y))
                 alert("found");
            this.head.x = X;
            this.head.y = Y;
            this.cells.push({x:X, y:Y});
            //console.log("headX: "+this.head.x+"  headY:"+this.head.y);
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
    food.draw();
}
function update()
{   
    //  Boundry conditionas
    if(snake.head.x>canvas.position.end.x)
    {
        //console.log("function update() -- 'left'");
        //console.log(snake.cells);
        //snake.cells.push({x:(snake.cells[0].x-snake.cs), y:snake.cells[0].y});
        //alert("XYZ");
        snake.direction = 'left';
    }

    else if(snake.head.x<canvas.position.start.x-snake.cs)
    {
        //console.log("function update() -- 'right'");
        //console.log(snake.cells);
        //alert("right");
        snake.direction = 'right';
    }

    else if(snake.head.y>canvas.position.end.y)
    {
        //console.log("function update() -- 'up'");
        //console.log(snake.cells);
        //alert("XYZ");
        snake.direction = 'up';
    }
    
    else if(snake.head.y<canvas.position.start.y)
    {
        //console.log("function update() -- 'down'");
        //console.log(snake.cells);
        //alert("XYZ");
        snake.direction = 'down';
    }
    snake.update();
}
function gameloop()
{
    draw();
    update();
}
function start()
{
    game.session = setInterval(gameloop, game.speed);

    function keyPressed(e)
    {
        //console.log(e.key);
        var direction = e.key.substring(5, e.key.length).toLowerCase();
        snake.direction = direction;
    }
    xyz=document.addEventListener('keydown', keyPressed);
}
function stop()
{
    clearInterval(game.session);
}
function operation_button(state, id)
{
    if(state=='Stop')
    {
        document.getElementById(id).value='Start';
        stop();
    }
    else if(state=='Start')
    {
        document.getElementById(id).value='Stop';
        start();
    }
}
init();
food.getRandom();
start();