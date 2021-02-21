
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

    canvas.position.end.x = canvas.w - canvas.position.start.x;
    canvas.position.end.y = canvas.w - canvas.position.start.y;
    main_canvas = document.getElementById("main_canvas");
    main_canvas.width = canvas.w;
    main_canvas.height = canvas.h;
    main_canvas.style.margin = canvas.margin;
    main_canvas.style.border = canvas.border;
    
    snake = {
        head:{
            x:canvas.position.start.x,
            y:canvas.position.start.y,
        },
        cells: [],
        direction: 'right',
        initial_size: 5,
        cs: 100,    // single cell size
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
            var headX = this.cells[this.cells.length-1].x;
            var headY = this.cells[this.cells.length-1].y;
            var X = headX;
            var Y = headY;
            var cons = this.cs;
            this.cells.shift();
            if(this.direction=='right')
            {
                X = X + cons;
                console.log("update:function() -- 'right'");
            }
            else if(this.direction=='left')
            {
                X = X - cons;
                console.log("update:function() -- 'left'");
            }
            else if(this.direction=='down')
            {
                Y = Y + cons;   
                console.log("update:function() -- 'down'");
            }
            else if(this.direction=='up')
            {
                Y = Y - cons;
                console.log("update:function() -- 'up'");
            }

            this.head.x = X;
            this.head.y = Y;
            console.log("headX: "+this.head.x+"  headY:"+this.head.y);
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
    //  Boundry conditionas
    var cons = snake.cs;
    if(snake.head.x>=canvas.position.end.x)
    {
        console.log("function update() -- 'left'");
        /*var headX = snake.cells[0].x;
        var headY = snake.cells[0].y;
        X = headX - cons;
        Y = headY;
        snake.head.x = X;
        snake.head.y = Y;
        snake.cells.pop();
        snake.cells.unshift({x:X, y:Y});*/
        snake.direction = 'left';
    }

    else if(snake.head.x<=canvas.position.start.x)
    {
        console.log("function update() -- 'right'");
        /*var headX = snake.cells[snake.cells.length-1].x;
        var headY = snake.cells[snake.cells.length-1].y;
        X = headX + cons;
        Y=headY;
        snake.head.x = X;
        snake.head.y = Y;
        snake.cells.shift();
        snake.cells.push({x:X, y:Y});*/
        snake.direction = 'right';
    }

    else if(snake.head.y>=canvas.position.end.y)
    {
        console.log("function update() -- 'up'");
        /*var headX = snake.cells[0].x;
        var headY = snake.cells[0].y;
        X = headX;
        Y = headY - cons;
        snake.head.x = X;
        snake.head.y = Y;
        snake.cells.pop();
        snake.cells.unshift({x:X, y:Y});*/
        snake.direction = 'up';
    }
    
    else if(snake.head.y<=canvas.position.start.y)
    {
        console.log("function update() -- 'down'");
        /*var headX = snake.cells[snake.cells.length-1].x;
        var headY = snake.cells[snake.cells.length-1].y;
        X = headX;
        Y = headY + cons;
        snake.head.x = X;
        snake.head.y = Y;
        snake.cells.shift();
        snake.cells.push({x:X, y:Y});*/
        snake.direction = 'down';
    }

    //else
    //{
        snake.update();
    //}
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