import React, { useEffect, useState } from 'react';
import axios from 'axios';
import EditItem from './EditItem';
import { useParams} from 'react-router-dom';



function ListItems(){
    const [items,setItems] = useState([]); 
    const [showEdit, setShowEdit] = useState(false);
    let params = useParams();


    useEffect(() => {
        axios.get("http://localhost:8080/getItemsByFolderId?folder_id="+params.id)
            .then(response => {
                setItems(response.data);
            })
            .catch(e => {
                console.log(e);
            })
    },[]) 

    function handleEditItem(){
        setShowEdit(true);
    }

    function handleDeleteItem(itemId){
        console.log("hola");
        axios.delete("http://localhost:8080/deleteItem?itemId="+itemId)
            .then(response => {
               window.location.reload(true);
            })
    }

    function handleStatusChange(id){
        axios.put("http://localhost:8080/changeItemStatus?itemId="+id)
            .then(response => {
                window.location.reload(true);
                
            })
    }

    return (
        <div className="table-responsive">
            <table className="table text-center">
                <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">Description</th>
                        <th scope="col">Status</th>
                        <th scope="col">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {items.length !== 0 ?
                        items.map(item => {
                            return(
                                <tr key={item.id}>
                                    <th scope="row">
                                        <div className="form-check form-switch d-flex justify-content-center">
                                            <input className="form-check-input" onClick={() => handleStatusChange(item.id)} type="checkbox" role="switch" id={item.id} checked={item.status === true}/>
                                        </div>
                                    </th>
                                    <td>{item.description}</td>
                                    <td>{item.status === false ? <p>Pending</p> : <p>Done</p>}</td>
                                    <td>
                                            <EditItem id={item.id}/>
                                            <button class="btn btn-danger" onClick={() => handleDeleteItem(item.id)} aria-current="page">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                                    <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                                </svg>
                                            </button>
                                            
                                    </td>
                                </tr>
                            )
                        })

                                
                        
                    
                    : null}
                    
                    
                </tbody>
            </table>
        </div>
    )
}

export default ListItems;



