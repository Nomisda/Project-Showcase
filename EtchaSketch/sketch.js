/*----Plan-----
-create main field  = done
-create mini boxes = done
-when hover they turn black = done
-create button that lets you create new grid = done
*/

//declaring important values
const body = document.querySelector("body");
const box = document.createElement("div");
const rButton = document.createElement("button"); //reset button
const boxside = 602;

//putting the main stuff in the middle
body.style.cssText=" height : 100vh; display : flex; align-items : center;  justify-content : center; flex-direction : column; "

body.style.cssText += "background-color : gray";

box.style.overflow="hidden";
box.style.height= boxside +"px";
box.style.maxwidth = boxside +"px";
box.id="box";
box.style.backgroundColor="white";
document.querySelector("body").appendChild(box);

rButton.textContent="Reset";
rButton.addEventListener("click", () => { 
    createGrid(prompt("how many rows and columns should your grid have?"));})
body.appendChild(rButton);

// functions-----------------------------------------------------

// creating the inner field

function createGrid(input){

    //making sure input is a number
    if (isNaN(input)) {alert("input is not a number!")}
    //making sure its not higher than 64x64
    else if (input > 64) {alert("Must be under 64");}
    //resets field
    else{
        box.innerHTML="";
    //creates all rows
    for (let col = 0; col != +input; col++){
        let row = document.createElement("div");
        row.style.height= boxside / input +"px";
        row.style.boxSizing="border-box";
        row.id =  "row-" + col ;
        box.appendChild(row);

        for (let row = 0; row != +input ; row++) {

            let pxl = document.createElement("div");
            pxl.style.border="solid black";
            pxl.style.borderWidth=".01px "
            pxl.style.borderCollapse="collapse"
            pxl.style.width= boxside/input + "px";
            pxl.style.height="100%";
            pxl.style.float="left";
            pxl.id=row;
            pxl.style.boxSizing="border-box";
            pxl.addEventListener("mouseover" ,() => {pxl.style.backgroundColor ="black";} )
            document.querySelector("#row-" + col).appendChild(pxl);

        }

        }
    }

}

createGrid(20);

