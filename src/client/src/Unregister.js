import React, { Component } from 'react';
import request from "request";
import { Link, withRouter } from "react-router-dom";
import {history} from "./History";
import Cookies from "./Cookies";


class Unregister extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            serverAddr: this.getServerAddr()
        };

        this.handleUnregister = this.handleUnregister.bind(this);
        this.handleGoBack = this.handleGoBack.bind(this);
        this.getUser = this.getUser.bind(this);
        this.getUser();
    }

    getServerAddr(){
        return process.env.REACT_APP_SERVER_ADDR
    }

    componentDidMount() {
        this.getUser();
    }

    getUser() {
        if(Cookies.readCookie('email') != null){
            this.setState({email: Cookies.readCookie('email')})
        }
        else{
            this.setState({email: "alex"})
        }
        //localStorage.getItem("email") ? this.setState({email: localStorage.getItem("email")}) : this.setState({email: "alex@email.com"});

    }

    handleUnregister(evt) {
        evt.preventDefault();
        const rqt = {
            "email" : this.state.email,
        };
        let url = this.state.serverAddr + "unregister";
        let options = {
            method: "POST",
            uri : url,
            body: JSON.stringify(rqt),
            insecure: true,
        };
        const self = this;
        request.post(options, function (error, response, body) {
            console.log('error:', error);
            console.log('statusCode:', response && response.statusCode);
            console.log('body:', body);
            if(body === 'true') {
                console.log('unregistered');
            }
            history.push('/');
        });
        return this.setState({ error: '' });
    }

    handleGoBack(evt){
        history.push('/Home');
    }


    render() {
        return (
            <div className="Unregister" style={{textAlignVertical: "center", textAlign: "center"}}>
                <h3>Are you sure you want to delete your account?</h3>
                <form onSubmit={this.handleUnregister}>
                    <button type="submit" value="Unregister" data-test="submit" variant="primary">Yes</button>
                </form>
                <form onSubmit={this.handleGoBack}>
                    <button type="submit" value="goback" data-test="submit" variant="primary">No</button>
                </form>
            </div>
        );
    }
}
export default withRouter(Unregister);
