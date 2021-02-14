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

function getIframeContent(chairman_circle) { 

    var frameObj = document.getElementById(chairman_circle); 

    var frameContent = frameObj.contentWindow.document.body.innerHTML; 
    //frameContent.select();
    //document.execCommand("copy")

    var $temp = $("<input>");
    $("body").append($temp);
    //$temp.val("ss").select();
    $temp.val(frameContent).select();
    document.execCommand("copy");
    $temp.remove();
    console.log(frameContent)
    //alert("frame content : " + frameContent); 
} 