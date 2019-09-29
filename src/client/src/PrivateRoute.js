import React from 'react';
import { Route, Redirect } from 'react-router-dom';
import { history } from './History';


export const PrivateRoute = ({ component: Component, wasInitialized, user, ...rest }: PrivateRouteProps) => (
    <Route wasInitialized={wasInitialized} user={user} render={props => (
        history.location.pathname === '/Home'
        // localStorage.getItem('user')
        ? <Component {...props} {...rest} />
            : !wasInitialized ?  ("")
            : <Redirect to={{ pathname: '/Login', state: { from: props.location } }} />
    )} />

)