import React, { Component } from 'react';
import {Link, withRouter} from "react-router-dom";
import request from 'request';

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
        console.log(localStorage.getItem("user"));
    }

    componentDidMount() {
        this.getGames();
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
            console.log('body:', body);
            console.log('Retrieved game');
            self.setState({games: body});
        });
    }

    render() {
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
                <h5>{this.state.games}</h5>
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
