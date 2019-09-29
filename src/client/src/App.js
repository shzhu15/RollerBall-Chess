import React, { Component } from 'react';
import request from 'request';
import { Router, Route, Switch, Redirect } from 'react-router-dom';
import Login from './Login';
import Register from './Register';
import Home from './Home';
import {PrivateRoute} from './PrivateRoute';
import { history } from './History';



export default class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            userID: ""
        };

        this.updateUser = this.updateUser.bind(this);
    }
    dummyApiCall() {

        request('http://localhost:4567/hello', function (error, response, body) {
            console.log('error:', error);
            console.log('statusCode:', response && response.statusCode);
            console.log('body:', body);
        });
    }

    updateUser(name) {
        this.setState({userID: name});
    }

    render() {
        // const renderMergedProps = (component, ...rest) => {
        //     const finalProps = Object.assign({}, ...rest);
        //     return (
        //         React.createElement(component, finalProps)
        //     );
        // }
        //
        // const PropsRoute = ({ component, ...rest }) => {
        //     return (
        //         <Route {...rest} render={routeProps => {
        //             return renderMergedProps(component, routeProps, rest);
        //         }}/>
        //     );
        // }
        return (
            <div>
                <Router history={history}>
                    <Switch>
                        <Redirect exact from="/" to="/Login" />
                        <Route path="/Login" render={(props) => <Login {...props} updateUser={this.updateUser}/>} />
                        <Route path="/Register" component={Register}/>
                        <PrivateRoute exact path="/Home" render={(props) => <Home {...props} updateUser={this.state.userID}/>}/>
                    </Switch>
                </Router>
                <br/>
                <br/>
                <br/>
                <br/>
            </div>

        );
    }
}
