import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router';



function ListFolders(){

    const [folders,setFolders] = useState([]);
    let params = useParams();


    useEffect(() => {
        axios.get("http://localhost:8080/getFoldersByUserId?user_id="+params.id)
            .then(response => {
                setFolders(response.data);
            })
    },[])

    function handleDeleteFolder(id){
        console.log(id);
        axios.delete("http://localhost:8080/deleteFolder?folder_id="+id)
            .then(response => {
                window.location.reload(true);
            })
    }

    return(
        <>
            {folders.length !== 0 ?
                folders.map(folder => {

                    return(
                        <>
                        <div className="row d-flex justify-content-center mt-4">
                            <div className="col-5">
                                <div className="card shadow">
                                    <div className="card-body bg-light">
                                        <h5> {folder.name}</h5> 
                                        <a type="button" href={"/items/"+folder.id+"/"+params.id} className="btn text-success btn-sm me-2">
                                            
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-eye" viewBox="0 0 16 16">
                                                <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                                                <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                                            </svg>
                                        </a>
                                        <button type="button" onClick={() => handleDeleteFolder(folder.id)} className="btn text-danger btn-sm">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-trash" viewBox="0 0 16 16">
                                                <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                                <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                            </svg>
                                        </button>
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                        

                        </>
                        
                    )
                })
            
            :
                <div class="alert alert-danger mt-3" role="alert">
                    You don't have folders, create one!
                </div>
            }
        </>

    )
}

export default ListFolders;