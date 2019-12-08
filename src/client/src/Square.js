import React, {Component} from 'react';
import './pieces.css';
import Cookies from "./Cookies";
import request from "request";

class Square extends Component {
    constructor(props){
        super(props);
        this.state = {
            id : props.id,
            piece : props.piece,
            shade : props.shade,
            style : props.style,
            board : props.board,
            x     : props.x,
            y     : props.y,
            isSelected : false,
            isSelectable: false,
        };
        this.handleClick = this.handleClick.bind(this);
        this.getClassName= this.getClassName.bind(this);
    }

    getClassName(){
        let className = "square " + this.state.shade + ((this.state.isSelected || this.state.isSelectable)?" select" : "");
        return className;
    }

    handleClick(){
        if(this.state.isSelectable){
            let oldX = this.state.board.getOldX();
            let oldY = this.state.board.getOldY();
            if(oldX === -1 || oldY === -1){
                console.log("Error This Should Never Happen");
                return;
            }
            console.log(oldX + " | " + oldY);
            console.log(this.state.x + " | " + this.state.y);
            const req = {
                "id": this.state.id,
                "player": Cookies.readCookie("email"),
                "oldX": oldX,
                "oldY": oldY,
                "newX": this.state.x,
                "newY": this.state.y

            };
            this.callMoveApi(req);
        }
        this.setState({isSelected: !this.state.isSelected});
        this.state.board.toggleMovablePositions(this.state.x, this.state.y);

    }

    callMoveApi(req){
        let url = this.state.board.state.addr + 'move';
        let options = {
            method: "POST",
            uri : url,
            body: JSON.stringify(req),
            insecure: true,
        };
        console.log("options: ",options);

        request.post(options, function (error, response, body) {
            console.log('error:', error);
            console.log('statusCode:', response && response.statusCode);
            console.log('body:', JSON.parse(body));
            window.location.reload();
        });
    }

    render() {
        let image = "";
        switch (this.state.piece) {
            case "KINGBLACK":
                image = "https://upload.wikimedia.org/wikipedia/commons/f/f0/Chess_kdt45.svg";
                break;
            case "ROOKBLACK":
                image = "https://upload.wikimedia.org/wikipedia/commons/f/ff/Chess_rdt45.svg";
                break;
            case "PAWNBLACK":
                image = "https://upload.wikimedia.org/wikipedia/commons/c/c7/Chess_pdt45.svg";
                break;
            case "BISHOPBLACK":
                image = "https://upload.wikimedia.org/wikipedia/commons/9/98/Chess_bdt45.svg";
                break;
            case "KINGWHITE":
                image = "https://upload.wikimedia.org/wikipedia/commons/4/42/Chess_klt45.svg";
                break;
            case "ROOKWHITE":
                image = "https://upload.wikimedia.org/wikipedia/commons/7/72/Chess_rlt45.svg";
                break;
            case "PAWNWHITE":
                image = "https://upload.wikimedia.org/wikipedia/commons/4/45/Chess_plt45.svg";
                break;
            case "BISHOPWHITE":
                image = "https://upload.wikimedia.org/wikipedia/commons/b/b1/Chess_blt45.svg";
                break;
            case "topleft":
                image = "https://upload.wikimedia.org/wikipedia/commons/e/ee/Font_Awesome_5_regular_caret-square-right.svg";
                break;
            case "topright":
                image = "https://upload.wikimedia.org/wikipedia/commons/d/df/Font_Awesome_5_regular_caret-square-down.svg";
                break;
            case "botleft":
                image = "https://upload.wikimedia.org/wikipedia/commons/2/24/Font_Awesome_5_regular_caret-square-up.svg";
                break;
            case "botright":
                image = "https://upload.wikimedia.org/wikipedia/commons/f/fd/Font_Awesome_5_regular_caret-square-left.svg";
                break;

        default:
    };
    return (
        <button
            ref={this.state.refId}
            className={this.getClassName()}
                style={this.state.style}
                onClick={this.handleClick}>
                <img src={image}/>


            </button>
        );
    }
}
export default Square;