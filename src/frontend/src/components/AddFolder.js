import axios from 'axios';
import React, { useState } from 'react';
import {useParams} from 'react-router';

function AddFolder(){

    const [folder, setFolder] = useState("");
    let params = useParams();
    
    function handleFolderChange(e){
        setFolder(e.target.value);
    }


    function handleFolderSubmit(e){
        e.preventDefault();
        axios.post("http://localhost:8080/createFolder?name="+folder+"&user_id="+params.id)
            .then(response => {
                window.location.reload(true);
            })
            .catch(e => {
                console.log(e);
            })
    }

    return(
        <>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end mb-3">
                <div >
                    <form onSubmit={handleFolderSubmit}>
                        <div className="row">
                            <div className="col-md-8">
                                <input type="text" class="form-control" value={folder} onChange={handleFolderChange} id="folder" placeholder="Daily reminders"/>
                            </div>
                            <div className="text-center mt-2 mb-3 m-md-0 col-md-4">
                                <button class="btn btn-success me-md-2" type="submit">Add</button>
                            </div>

                        </div>
                    </form>
                   
                </div>
                
            </div>

        </>
    )

}

export default AddFolder;