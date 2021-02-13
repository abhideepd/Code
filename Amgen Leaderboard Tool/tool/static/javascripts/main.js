function current_BU_TEAM_LEVEL(){
    current_BU_TEAM_LEVEL_ID = document.getElementById("select_BU_TEAM_LEVEL");
    current_BU_TEAM_LEVEL_NAME = current_BU_TEAM_LEVEL_ID.options[current_BU_TEAM_LEVEL_ID.selectedIndex].value;
    return current_BU_TEAM_LEVEL_NAME;
}

function rankpool_pseudo_name(id, value){
    fetch('http://localhost:5000/leaderboard_generation', {
    method: 'POST', 
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
    Id: id,
    rankpool_pseudoname: value,
    current_BU_TEAM_LEVEL_NAME: current_BU_TEAM_LEVEL()
})}).then(results=>results.json());
}

function refresh_config(){
    fetch('http://localhost:5000/leaderboard_generation', {
    method: 'POST', 
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
    Refresh_config:'Refresh COnfiguration'

})}).then(results=>results.json());
}

function switch_off_visiblity(){
    document.getElementById('submit_BU').style.display='none';
}

function submit_visible(){
document.getElementById('submit_BU').style.display='block';
}

function rankpool_visibility_checkbox(id, check_status){
fetch('http://localhost:5000/leaderboard_generation', {
    method: 'POST', 
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
    Id:id,
    Rank_Pool_Visibility:(check_status?'1':'0'),
    current_BU_TEAM_LEVEL_NAME:current_BU_TEAM_LEVEL()

})}).then(results=>results.json());
/*location.reload();*/
}
