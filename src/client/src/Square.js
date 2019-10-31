import React from 'react';

import pieces from './pieces.css';

export default function Square(props) {
    let image = "";
    switch(props.piece){
        case "KINGBLACK": image = "https://upload.wikimedia.org/wikipedia/commons/f/f0/Chess_kdt45.svg";break;
        case "ROOKBLACK": image = "https://upload.wikimedia.org/wikipedia/commons/f/ff/Chess_rdt45.svg";break;
        case "PAWNBLACK": image = "https://upload.wikimedia.org/wikipedia/commons/c/c7/Chess_pdt45.svg";break;
        case "BISHOPBLACK": image = "https://upload.wikimedia.org/wikipedia/commons/9/98/Chess_bdt45.svg";break;
        case "KINGWHITE": image = "https://upload.wikimedia.org/wikipedia/commons/4/42/Chess_klt45.svg";break;
        case "ROOKWHITE": image = "https://upload.wikimedia.org/wikipedia/commons/7/72/Chess_rlt45.svg";break;
        case "PAWNWHITE": image = "https://upload.wikimedia.org/wikipedia/commons/4/45/Chess_plt45.svg";break;
        case "BISHOPWHITE": image = "https://upload.wikimedia.org/wikipedia/commons/b/b1/Chess_blt45.svg";break;
        case "topleft": image = "https://upload.wikimedia.org/wikipedia/commons/e/ee/Font_Awesome_5_regular_caret-square-right.svg";break;
        case "topright": image = "https://upload.wikimedia.org/wikipedia/commons/d/df/Font_Awesome_5_regular_caret-square-down.svg";break;
        case "botleft": image = "https://upload.wikimedia.org/wikipedia/commons/2/24/Font_Awesome_5_regular_caret-square-up.svg";break;
        case "botright": image = "https://upload.wikimedia.org/wikipedia/commons/f/fd/Font_Awesome_5_regular_caret-square-left.svg";break;

        default:
    };
    return (
        <button
            className={"square " + props.shade}
                onClick={props.onClick}
                style={props.style}>
               <img src = {image}/>


        </button>
    );
}