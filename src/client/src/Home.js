import React, { Component } from 'react';
import {Link, withRouter} from "react-router-dom";
import request from 'request';
import Board from "./Board";

class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: '',
            email: '',
            password: '',
            error: '',
            games: '',
        };

        this.getUser = this.getUser.bind(this);
        this.getGames = this.getGames.bind(this);
        this.makeBoards = this.makeBoards.bind(this);
        console.log(localStorage.getItem("user"));
        this.getGames();
    }

    componentDidMount() {
        this.getUser();
    }

    getUser() {
        this.setState({user: localStorage.getItem("user")});
    }

    getGames() {
        const rqt = {
            "email" : localStorage.getItem("email"),
        };
        let options = {
            method: "GET",
            uri : "http://localhost:4567/getGame",
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
                    boards.push(<Board pieces={game.board.pieces}/>);
                })
            }
        }
        if(this.state.games.pending){
            if(this.state.games.pending[0]){
                this.state.games.pending.forEach((game) => {
                    boards.push(<Board pieces={game.board.pieces}/>);
                })
            }
        }
        if(this.state.games.active){
            if(this.state.games.active[0]){
                this.state.games.active.forEach((game) => {
                    boards.push(<Board pieces={game.board.pieces}/>);
                })
            }
        }
        return boards;
    }

    render() {
        const boards = this.makeBoards();
        return (
            <div className="Home" style={{textAlignVertical: "center", textAlign: "center"}}>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <header>
                    <p>
                        Home
                    </p>
                </header>
                <h1>Hi {this.state.user}</h1>

                <h5>Here are your active games</h5>
                {boards}
            <form>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <Link to="/">logout</Link>
            </form>
            </div>
        );
    }
}
export default withRouter(Home);
