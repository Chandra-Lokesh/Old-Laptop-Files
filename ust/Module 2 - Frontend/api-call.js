// https://api.github.com/users/chandra-lokesh

// function fetchGithubUser(username){
//     fetch("https://api.github.com/users/" + username)
//     .then(response => response.json().then(data => console.log(data)))
//     .catch(error => console.error(error))
// }

async function fetchGithubUser(username){
    let response = await fetch("https://api.github.com/users/" + username)
    let data = await response.json();
    console.log(data);
    return data
}

