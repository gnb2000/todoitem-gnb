import axios from 'axios';
import React, { useState } from 'react';
import { useHistory } from 'react-router';
import CreateAccount from '../components/CreateAccount';
import '../css/home.css';

function Login(){
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    let history = useHistory();

    function handleUsernameChange(e){
        setUsername(e.target.value);
    }

    function handlePasswordChange(e){
        setPassword(e.target.value);
    }

    function handleLoginSubmit(e){
        e.preventDefault();
        axios.get("http://localhost:8080/getUserByUsernameAndPassword?username="+username+"&password="+password)
            .then(response => {
                history.push("/home/"+response.data.id);
            })
            .catch(error => {
                console.log(e);
            })
    }


    return (
        <div className="contenedor d-flex justify-content-center align-items-center">
            <div className="p-5 bg-light shadow">
                <h4>Welcome to To-Do-Item</h4>
                <form className="mt-3" onSubmit={handleLoginSubmit}>
                    <div className="mb-3">
                        <label class="form-label">Username</label>
                        <input type="text" value={username} onChange={handleUsernameChange} className="form-control" id="username"/>
                    </div>
                    <div className="mb-3">
                        <label className="form-label">Password</label>
                        <input type="password" value={password} onChange={handlePasswordChange} className="form-control" id="password"/>
                    </div>
                    <div className="mb-3 text-center">
                        <button type="submit" className="btn btn-success">Login</button>
                    </div>
                    <div className="mb-3 text-center">
                        <CreateAccount/>
                    </div>
                    

                </form>

            </div>

        </div>
    )


}

export default Login;