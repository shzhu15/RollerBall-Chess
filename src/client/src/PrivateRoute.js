import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import { history } from './History';


export const PrivateRoute = ({ component: Component, ...rest }: PrivateRouteProps) => (
    <Route {...rest} render={props => (
        history.location.pathname === '/Home'
        ? <Component {...props} />
            : <Redirect to={{ pathname: '/Login', state: { from: props.location } }} />
    )} />

)