const BASE_URL = "http://localhost:3000/tasks";

async function addTask(task){
    const response = await fetch(BASE_URL,{
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(task)
    });
    const data = await response.json();
    return data;
}

async function getTasks(){
    const response = await fetch(BASE_URL);
    const data = await response.json();
    return data;
}

async function deleteTask(id){
    const response = await fetch(`${BASE_URL}/${id}`,
        {
            method: 'DELETE'
        }
    );
    const data = await response.json();
    return data;
}
