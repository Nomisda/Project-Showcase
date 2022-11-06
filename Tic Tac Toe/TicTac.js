var win = false;
var Counter = 0; // Turn Counter for performance + Tie
var field = new Array(10); // field[0] = X or O turn
field [0] = true;
var wins = [ 
    [1,2,3],[4,5,6],[7,8,9],[1,4,7],[2,5,8],[3,6,9],[1,5,9],[3,5,7] 
];
var winlen = wins.length; // small performance + for winning()


function play(a,b){
    console.clear();
    if ( field[+a] ===undefined && win == false) {
        value(a);
    }
    if ( Counter > 4 ){
        winning();
    }
    if ( Counter == 9 && win == false ){
        document.getElementById("header").innerHTML="TIE!"
    }

}

function value(Pos){
    switch(field[0]) {
    case true : 
        field[+Pos] = "X";
        document.getElementById(Pos).innerHTML="X";
        field[0] = false;
        break;
    case false :
        field[+Pos] = "O";
        document.getElementById(Pos).innerHTML="O";
        field[0] = true;
    }
    Counter++;
}


function winning(){
    for(let x = 0; x < winlen;x++){
        if ( field[wins[x][0]] == undefined || field[wins[x][1]] == undefined || field[wins[x][2]] == undefined){continue;}
        

        if (field[wins[x][0]] == field[wins[x][1]] && field[wins[x][1]] == field[wins[x][2]]){
            winner();
        }
    }
}

function winner(){
    switch (field[0]){
        case false :
            document.getElementById("header").innerHTML="X won"
            document.getElementById("header").style.color="blue"
            break;

        case true :
            document.getElementById("header").innerHTML="O won"
            document.getElementById("header").style.color="red"
            break;
    }
    win = true;
}