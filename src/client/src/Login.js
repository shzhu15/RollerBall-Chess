import React, { Component } from 'react';
import App from "./App";
import request from "request";
import Register from "./Register"
// import Button from 'react-bootstrap/Button';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
// import { Link } from 'react-router';

class Login extends Component {
    constructor() {
        super();
        this.state = {
            email: '',
            password: '',
            error: '',
        };

        this.handlePassChange = this.handlePassChange.bind(this);
        this.handleUserChange = this.handleUserChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.dismissError = this.dismissError.bind(this);
    }


    dismissError() {
        this.setState({ error: '' });
    }

    handleSubmit(evt) {
        evt.preventDefault();

        if (!this.state.email) {
            return this.setState({ error: '  Email is required' });
        }

        if (!this.state.password) {
            return this.setState({ error: '  Password is required' });
        }
        const rqt = {
            'email': this.state.email,
            'password': this.state.password
        };

        request.post('http://localhost:4567/login', rqt, function (error, response, body) {
            console.log('error:', error);
            console.log('statusCode:', response && response.statusCode);
            console.log('body:', body);
        });
        // request('http://localhost:4567/login', rqt,function (error, response, body)).then((response) => {
        //         console.log('error:', error);
        //         console.log('statusCode:', response && response.statusCode);
        //         console.log('body:', body);
        //         if(response.body == "pass") {
        //             <Login />
        //         }
        //     }
        // );
        return this.setState({ error: '' });
    }

    handleUserChange(event) {
        this.setState({
            email: event.target.value,
        });
    };

    handlePassChange(event) {
        this.setState({
            password: event.target.value,
        });
    }


    render() {
        return (
            <div className="Login" style={{textAlignVertical: "center", textAlign: "center"}}>
                <form onSubmit={this.handleSubmit}>

                    {
                        this.state.error &&
                        <h3 data-test="error" onClick={this.dismissError} style={{ color: 'red' }}>
                            <button onClick={this.dismissError}>✖</button>
                            {this.state.error}
                        </h3>
                    }
                    <label style={{textAlignVertical: "center", textAlign: "center", fontSize: 64 }}>
                        RollerBall
                        <br />
                    </label>
                    <br />
                    <label style={{textAlignVertical: "center", textAlign: "center", fontSize: 20 }}>
                        Email
                        <br />
                        <input type="text" data="email"
                               value={this.state.email} onChange={this.handleUserChange} />
                    </label>
                    <br />
                    <label style={{textAlignVertical: "center", textAlign: "center", fontSize: 20 }}>
                        Password
                        <br />
                        <input type="password" data="password"
                               value={this.state.password} onChange={this.handlePassChange} />
                    </label>
                    <br />
                    <br />
                    <button type="submit" value="Login" data-test="submit" variant="primary">login</button>
                </form>
                <br />
                <br />
                <Router>
                    <div>
                        <Route path="/register" component={Register} />
                        <Link to={"/Register"} className="btn btn-link">register</Link>
                    </div>
                </Router>

            </div>
        );
    }
}
export default Login;