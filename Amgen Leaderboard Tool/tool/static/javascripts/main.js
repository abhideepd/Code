function current_BU_TEAM_LEVEL(){
    current_BU_TEAM_LEVEL_ID = document.getElementById("select_BU_TEAM_LEVEL");
    current_BU_TEAM_LEVEL_NAME = current_BU_TEAM_LEVEL_ID.options[current_BU_TEAM_LEVEL_ID.selectedIndex].value;
    return current_BU_TEAM_LEVEL_NAME;
}

function rankpool_pseudo_name(id, value){
    fetch('http://localhost:5000/configurator', {
    method: 'POST', 
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
    Id: id,
    rankpool_pseudoname: value,
    current_BU_TEAM_LEVEL_NAME: current_BU_TEAM_LEVEL()
})}).then(results=>{
    REFRESH_chairman_circle()
    results.json()
});
}

function refresh_config(){
    fetch('http://localhost:5000/configurator', {
    method: 'POST', 
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
    Refresh_config:'Refresh Configuration'

})}).then(results=>results.json());
}

function switch_off_visiblity(){
    document.getElementById('submit_BU').style.display='none';
}

function REFRESH_chairman_circle(){
    document.getElementById('chairman_circle').contentDocument.location.reload(true);
}

function submit_visible(){
document.getElementById('submit_BU').style.display='block';
}

function rankpool_visibility_checkbox(id, check_status){
fetch('http://localhost:5000/configurator', {
    method: 'POST', 
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
    Id:id,
    Rank_Pool_Visibility:(check_status?'1':'0'),
    current_BU_TEAM_LEVEL_NAME:current_BU_TEAM_LEVEL()

})}).then(results=>{
    REFRESH_chairman_circle()
    results.json()
});
}

function getIframeContent() { 

    var frameObj = document.getElementById('chairman_circle'); 
    var frameContent = frameObj.contentWindow.document.body.innerHTML; 

    var el = document.createElement('textarea');
    el.value = frameContent;

    el.setAttribute('readonly', '');
    el.style = {position: 'absolute', left: '-9999px'};
    document.body.appendChild(el);
    el.select();
    document.execCommand('copy');
    document.body.removeChild(el);
    //copy_button();
}

function leaderboard_parameter(parameter, parameter_value){
    fetch('http://localhost:5000/configurator', {
    method: 'POST', 
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
    parameter: parameter,
    parameter_value: parameter_value,
    current_BU_TEAM_LEVEL_NAME:current_BU_TEAM_LEVEL()

})}).then(results=>{
    REFRESH_chairman_circle()
    results.json()
});
}

function copy_button(){
    document.getElementById("copy_button").innerHTML="Copied !";
}

function copy_button_reverse(){
    document.getElementById("copy_button").innerHTML="Copy HTML";
}

function iframe_scroll(scroll_type){
    document.getElementById("chairman_circle").scrolling=scroll_type;
}


function getIframeContent_1() { 

    var frameObj = document.getElementById('calender'); 
    var frameContent = frameObj.contentWindow.document.body.innerHTML; 

    var el = document.createElement('textarea');
    el.value = frameContent;

    el.setAttribute('readonly', '');
    el.style = {position: 'absolute', left: '-9999px'};
    document.body.appendChild(el);
    el.select();
    document.execCommand('copy');
    document.body.removeChild(el);
    //copy_button();
}

function copy_button_1(){
    document.getElementById("copy_button_1").innerHTML="Copied !";
}

function copy_button_reverse_1(){
    document.getElementById("copy_button_1").innerHTML="Copy HTML";
}

function iframe_scroll_1(scroll_type){
    document.getElementById("calender").scrolling=scroll_type;
}

function submit_visible_1()
{
    document.getElementById('generate_calender').style.display='block';
}

function switch_off_visiblity_1()
{
    document.getElementById('generate_calender').style.display='none';
}