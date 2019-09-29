import React, { Component } from 'react';
import {Link, withRouter} from "react-router-dom";

class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            user: '',
            email: '',
            password: '',
            error: '',
        };

        this.getUser = this.getUser.bind(this);
        console.log(localStorage.getItem("user"));
    }

    componentDidMount() {
        this.getUser();
    }
    //
    // componentDidMount(prevProps) {
    //     if(this.props !== prevProps) {
    //
    //     }
    // }

    getUser() {
        this.setState({user: localStorage.getItem("user")});
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
