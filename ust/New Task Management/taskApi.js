const baseUrl = "http://localhost:8000/api/v1/tasks"
// const baseUrl = "http://localhost:3000/tasks"

async function addTask(task){
    const response = await fetch(baseUrl, {
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
    const response = await fetch(baseUrl);
    const data = await response.json();
    return data;
}

async function getDeletedTasks(){
    const response = await fetch(`${baseUrl}/inactive`);
    const data = await response.json();
    return data;
}

async function getTaskById(id){
    const response = await fetch(`${baseUrl}/${id}`, {
        method: 'GET'
    });
    const data = await response.json();
    return data;
}

async function deleteTask(id){
    const response = await fetch(`${baseUrl}/soft-deltete/${id}`, {
        method: 'DELETE'
    });
    const data = await response.json();
    return data;
}

async function updateTask(task){
    const response = await fetch(`${baseUrl}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(task)
    });
    const data = response.json();
    return data;
}

async function searchByStatus(status){
    const response = await fetch(`${baseUrl}/status/${status}`);
    const data = response.json();
    return data;
}

async function getSortedTasks(){
    const response = await fetch(`${baseUrl}/sort`);
    return response.json();
}
