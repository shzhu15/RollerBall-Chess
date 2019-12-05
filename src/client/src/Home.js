import React, { Component } from 'react';
import {Link, withRouter} from "react-router-dom";
import request from 'request';
import Board from "./Board";
import MoveSubmission from "./MoveSubmission";

class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: '',
            email: '',
            password: '',
            error: '',
            games: '',
            serverAddr: this.getServerAddr()
        };

        this.getUser = this.getUser.bind(this);
        this.getGames = this.getGames.bind(this);
        this.makeBoards = this.makeBoards.bind(this);
        this.getUser();
        this.getGames();

    }

    getServerAddr(){
        return process.env.REACT_APP_SERVER_ADDR
    }

    componentDidMount() {
        this.getUser();
    }

    getUser() {
        localStorage.getItem("user") ? this.setState({user: localStorage.getItem("user")}) : this.setState({user: "alex"});

    }

    getGames() {
        let email = localStorage.getItem("email");
        localStorage.getItem("email") ? email = localStorage.getItem("email") : email = "alex@email.com";
        const rqt = {
            "email" : email,
        };
        let url = this.state.serverAddr + "getGame"
        let options = {
            method: "GET",
            uri : url,
            body: JSON.stringify(rqt),
            insecure: true,
        };
        const self = this;
        request.post(options, function (error, response, body) {
            console.log('error:', error);
            console.log('statusCode:', response && response.statusCode);
            console.log('body:', JSON.parse(body));
            console.log('Retrieved game');
            self.setState({games: JSON.parse(body)});
        });
    }

    makeBoards() {
        let boards = [];
        if(this.state.games.sent){
            if(this.state.games.sent[0]){
                this.state.games.sent.forEach((game) => {
                    boards.push(<Board id={game.id} pieces={game.board.pieces}/>);
                    boards.push(<br/>);
                    boards.push(<MoveSubmission getGames={this.getGames} id={game.id}/>);

                })
            }
        }
        if(this.state.games.pending){
            if(this.state.games.pending[0]){
                this.state.games.pending.forEach((game) => {
                    boards.push(
                        <Board id={game.id} pieces={game.board.pieces}/>
                        );
                    boards.push(<br/>);
                    boards.push(<MoveSubmission getGames={this.getGames} id={game.id}/>);
                })
            }
        }
        if(this.state.games.active){
            if(this.state.games.active[0]){
                this.state.games.active.forEach((game) => {
                    boards.push(
                        <Board id={game.id} pieces={game.board.pieces}/>
                        );
                    boards.push(<br/>);
                    boards.push(<MoveSubmission getGames={this.getGames} id={game.id}/>);
                })
            }
        }
        return boards;
    }

    render() {
        const boards = this.makeBoards();
        return (
            <div className="Home"style={{textAlignVertical: "center", textAlign: "center"}}>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <header>
                    <p style={{fontSize: "30px"}}>
                        Home
                    </p>
                </header>
                <h1>Hi {this.state.user}</h1>

                <h5 style={{fontSize: "30px"}}>Here are your active games</h5>
                <div style={{textAlignVertical: "left", textAlign: "left"}}>
                {boards}
                </div>
            <form>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <Link to="/">logout</Link>
                <br/>
                <Link to="/Unregister">unregister account</Link>
            </form>
            </div>
        );
    }
}
export default withRouter(Home);
