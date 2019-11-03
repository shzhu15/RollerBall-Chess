import React, { Component } from 'react';
import Square from './Square.js';

class Board extends Component {
    constructor(props) {
        super(props);
        this.state = {
            board: " ",
            pieces: this.props.pieces,

        };
        //this.initialize = this.initialize.bind(this);
    }
    renderSquare(i, squareShade, type) {
        return <Square
            piece = {type}
            shade = {squareShade}
        />
    }

    render() {
        const board = [];
        for(let i = 0; i < 7; i++){
            const squareRows = [];
            for(let j = 0; j < 7; j++){
                let pieceName = "none";
                console.log(pieceName);

                // Set piece colors (blacked out for middle section)
                let squareShade = ((i%2 === 0) &&(j%2 === 0) || (i%2 !== 0) && (j%2 !== 0))? "light-square" : "dark-square";
                if(( i > 1 && i < 5) && (j > 1 && j < 5)) squareShade = "black-square";

                // Set piece image (will be an arrow unless a piece occupies the corner)
                if(i === 6 && j === 6) pieceName = "botright";
                if(i === 0 && j === 6) pieceName = "topright";
                if(i === 0 && j === 0) pieceName = "topleft";
                if(i === 6 && j === 0) pieceName = "botleft";
                this.props.pieces.forEach((piece) => {
                    if(piece.location.x === j && piece.location.y === i) {
                        pieceName = piece.type + piece.pieceColor;
                    }
                });
                squareRows.push(this.renderSquare((i*7) + j, squareShade, pieceName));
            }
            board.push(<div className="board-row">{squareRows}</div>)
        }


        return (
            <div>
                {board}
            </div>
        );
    }
}
export default Board;