import React, { Component } from 'react';
import Square from './Square.js';
import {findDOMNode} from "react-dom";

class Board extends Component {
    constructor(props) {
        super(props);
        this.state = {
            id: this.props.id,
            addr: this.props.addr,
            squares: [],
            pieces: this.props.pieces,
            toggle: false,
            selectedSpace: null,
            selectableSpaces: [],
            oldX: -1,
            oldY: -1

        };
        this.toggleMovablePositions = this.toggleMovablePositions.bind(this);
        this.createBoard = this.createBoard.bind(this);
        //this.initialize = this.initialize.bind(this);
    }

    createBoard(){
        this.state.squares = [];
        let board = [];
        for(let i = 0; i < 7; i++){
            let squareRows = [];
            for(let j = 0; j < 7; j++){
                let pieceName = "none";
                //console.log(pieceName);

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
                squareRows.push(this.renderSquare((i*7) + j, squareShade, pieceName, i, j));
                this.state.squares.push(squareRows[squareRows.length-1].ref);
            }
            board.push(<div className="board-row">{squareRows}</div>);

        }
        return board;
    }

    getOldX(){
        return this.state.oldX;
    }

    getOldY(){
        return this.state.oldY;
    }

    renderSquare(i, squareShade, type, y, x) {
        return <Square
            ref={React.createRef()}
            id = {this.state.id}
            piece = {type}
            shade = {squareShade}
            board = {this}
            x = {x}
            y = {y}
        />
    }

    toggleMovablePositions(x, y){
        this.state.toggle = !this.state.toggle;
        if(this.state.toggle === false){
            this.state.selectedSpace = null;
            this.state.selectableSpaces = [];
        }
        else {
            this.state.selectedSpace = {'x': x, 'y': y};
            this.state.pieces.forEach(piece => {
                if (piece.location.x === x && piece.location.y === y) {
                    this.state.selectableSpaces = piece.possibleMoves;
                    this.state.oldX = x;
                    this.state.oldY = y;

                }
            });
        }
        this.setState(this.state);
        // console.log("toggle: " + this.state.toggle);
        // console.log(this.state.selectableSpaces);
        this.state.squares.forEach(squareRef=>{
           this.state.selectableSpaces.forEach(selectableSpace =>{
               if(squareRef.current.props.x === selectableSpace.x && squareRef.current.props.y === selectableSpace.y){
                  squareRef.current.setState({isSelectable: true});
               }
           });
        });
        if(!this.state.toggle){
            this.state.squares.forEach(squareRef=>{
                squareRef.current.setState({isSelectable: false,  isSelected: false});
                this.setState({oldX: -1, oldY: -1});
            })
        }

    }

    render() {
        return (
            <div>
                {this.createBoard()}
            </div>
        );
    }
}
export default Board;