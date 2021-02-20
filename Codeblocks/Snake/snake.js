
function init()
{
    main_canvas = document.getElementById("main_canvas");
    main_canvas.width = main_canvas.height = 2000;
    main_canvas.margin = '10px';
    main_canvas.border = '1px solid black'
    
    rect = {
        x:10,
        y:10,
        w:90,
        h:90,
        speed:10,
    }
    pen = main_canvas.getContext('2d');
    pen.fillStyle = "red";
    
}
function draw()
{
    pen.fillRect(rect.x, rect.y, rect.w, rect.h);
}
function update()
{
    rect.x += rect.speed;
}
function gameloop()
{
    draw();
    update();
    setInterval(draw, 100);
}
function start()
{
     
}
init();
gameloop();