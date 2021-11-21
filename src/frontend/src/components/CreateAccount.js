import React, { useState } from 'react';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import axios from 'axios';
import { useHistory } from 'react-router';

function CreateAccount(){

    const [newUsername, setNewUsername] = useState("");
    const [newPassword, setNewPassword] = useState("");
    const [confirmPass, setConfirmPass] = useState("");
    let history = useHistory();

    function handleNewUsernameChange(e){
        setNewUsername(e.target.value);
    }

    function handleNewPasswordChange(e){
        setNewPassword(e.target.value);
    }

    function handleConfirmPassChange(e){
        setConfirmPass(e.target.value);
    }

    function handleNewAccountSubmit(){
        if (newPassword !== confirmPass){
            toast.error("Password must be equals");
        } else {
            axios.post("http://localhost:8080/createUser?username="+newUsername+"&password="+newPassword)
                .then(res => {
                    toast.success("The account was created successfully")
                    setTimeout(() => {
                        window.location.reload(true);
                    },2000)
                })
                .catch(e => {
                    toast.error("ERROR, try again");
                })
        }

    }

    
    
    return (
        <>
            <button class="btn btn-warning text-dark" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasRight" aria-controls="offcanvasRight">Create account</button>
            <ToastContainer/>
            <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasRight" aria-labelledby="offcanvasRightLabel">
                <div class="offcanvas-header">
                    <h5 id="offcanvasRightLabel">Create new account</h5>
                    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                    <form>
                        <div class="mb-3">
                            <label class="form-label">Username</label>
                            <input type="text" value={newUsername} onChange={handleNewUsernameChange}  class="form-control" id="username"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input type="password" value={newPassword} onChange={handleNewPasswordChange} class="form-control" id="password"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Confirm password</label>
                            <input type="password" value={confirmPass} onChange={handleConfirmPassChange} class="form-control" id="password"/>
                        </div>

                        <button type="button" onClick={handleNewAccountSubmit} class="btn btn-success">Register</button>
                    </form>
                </div>
            </div>
            
        </>
    )

}

export default CreateAccount;