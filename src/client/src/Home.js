import React, { Component } from 'react';
import {Link, withRouter} from "react-router-dom";
import request from 'request';
import Board from "./Board";
import MoveSubmission from "./MoveSubmission";
import GameHistory from "./GameHistory";
import Cookies from "./Cookies";
import Rules from "./Rules";
import Invite from "./Invite";
import { Tab, Tabs, TabList, TabPanel } from 'react-tabs';
import 'react-tabs/style/react-tabs.css';


class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: '',
            email: '',
            password: '',
            error: '',
            games: '',
            serverAddr: this.getServerAddr(),
            modalIsOpen: false,
        };

        this.getUser = this.getUser.bind(this);
        this.getGames = this.getGames.bind(this);
        this.makeBoards = this.makeBoards.bind(this);
        this.openModal = this.openModal.bind(this);
        this.closeModal = this.closeModal.bind(this)
        this.getUser();
        this.getGames();
        this.makeBoards();


    }

    getServerAddr(){
        return process.env.REACT_APP_SERVER_ADDR
    }

    componentDidMount() {
        this.getUser();
    }

    getUser() {
        if(Cookies.readCookie('user') != null){
            this.setState({user: Cookies.readCookie('user')})
        }
        else{
            this.setState({user: "alex"})
        }
        // localStorage.getItem("user") ? this.setState({user: localStorage.getItem("user")}) : this.setState({user: "alex"});

    }

    getGames() {
        let email = localStorage.getItem("email");
        // localStorage.getItem("email") ? email = localStorage.getItem("email") : email = "alex@email.com";
        if(Cookies.readCookie('email') != null){
            email = Cookies.readCookie('email')
            this.state.email = email;
        }
        else{
            email = "alex@email.com"
        }
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
            if(body != undefined) {
                console.log('error:', error);
                console.log('statusCode:', response && response.statusCode);
                console.log('body:', JSON.parse(body));
                console.log('Retrieved game');
                self.setState({games: JSON.parse(body)});
            }
        });
    }

    makeBoards() {
        let boards = [];

        if(this.state.games.sent){
            if(this.state.games.sent[0]){
                //
                // this.state.games.sent.forEach((game) => {
                //     let name = this.state.user != game.p2Name ? game.p2Name : game.p1Name;

                /*this.state.games.sent.forEach((game) => {

                    boards.push(<br/>);
                    boards.push("Versus:  " + name);
                    boards.push(<Board id={game.id} pieces={game.board.pieces}/>);
                    boards.push(<br/>);
                    boards.push(<MoveSubmission getGames={this.getGames} id={game.id}/>);

                })*/
            }

        }
        if(this.state.games.pending){
            if(this.state.games.pending[0]){

                // this.state.games.pending.forEach((game) => {
                //     let name = this.state.user != game.p2Name ? game.p2Name : game.p1Name;

                /*this.state.games.pending.forEach((game) => {

                    boards.push(<br/>);
                    boards.push("Versus:  " + name);
                    boards.push(
                        <Board id={game.id} pieces={game.board.pieces}/>
                    );
                    boards.push(<br/>);
                    boards.push(<MoveSubmission getGames={this.getGames} id={game.id}/>);
                })*/
            }
        }
        const tabFull = [];
        if(this.state.games.active){
            if(this.state.games.active[0]){
                const tabHeaders = [];
                const tabLists = [];

                this.state.games.active.forEach((game) => {
                    let name = this.state.user != game.p2Name ? game.p2Name : game.p1Name;

                   tabHeaders.push(<Tab>Game with {game.p1}</Tab>);


                    boards = [];

                    boards.push(<br/>);
                    boards.push("Versus:  " + name);
                    console.log("Here:" + game.p1);
                    console.log("Here:" + this.state.email);
                    if(game.p1 == this.state.email){
                        boards.push(<br/>);
                        boards.push("\nYou Are White");
                        if(game.turn % 2 === 0){
                            boards.push(<br/>);
                            boards.push("It Is Your Turn!");
                        }
                        else{
                            boards.push(<br/>);
                            boards.push("It Is Not Your Turn");
                        }
                    }
                    else{
                        boards.push(<br/>);
                        boards.push("You Are Black");
                        if(game.turn % 2 === 1){
                            boards.push(<br/>);
                            boards.push("It Is Your Turn!");
                        }
                        else{
                            boards.push(<br/>);
                            boards.push("It Is Not Your Turn");
                        }
                    }
                    boards.push(
                        <Board id={game.id} pieces={game.board.pieces} addr={this.state.serverAddr}/>
                    );
                    boards.push(<br/>);
                    tabLists.push(<TabPanel>
                        {boards}
                    </TabPanel>);
                });
                tabFull.push(<Tabs inkBarStyle={{background: 'blue'}}>
                    <TabList>
                        {tabHeaders}
                    </TabList>
                    {tabLists}
                </Tabs>);
                console.log(tabHeaders);
            }
        }

        return tabFull;
    }

    openModal(){
        this.setState({modalIsOpen:true})
    }
    closeModal(){
        this.setState({modalIsOpen:false})
    }


    render() {
        const boards = this.makeBoards();
        console.log("-------games from Home -------------")
        console.log(this.state.games.finished)
        console.log("-------end games from Home -------------")

        return (

            <div className="Home"style={{textAlignVertical: "center", textAlign: "center"}}>
                <br/>
                <br/>
                <br/>
                <br/>
                <br/>
                <h1>Hi {this.state.user}</h1>
                <div className="Buttons" style={{display: 'inline-flex'}}>
                    <Rules/>
                    <GameHistory
                        finishedGames={this.state.games.finished}
                    />
                    <br/>

                    <Invite
                        games={this.state.games.finished}
                    />
                    <button><Link to="/">logout</Link></button>
                    <button><Link to="/Unregister">unregister account</Link></button>
                </div>
                <h5 style={{fontSize: "30px"}}>Here are your active games</h5>
                <div style={{textAlignVertical: "left", textAlign: "left"}}>
                    {boards}
                </div>

            </div>
        );
    }
}

export default withRouter(Home);
