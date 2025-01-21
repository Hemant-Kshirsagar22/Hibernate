
var btn = document.getElementById("btn");
var msg = document.getElementById("msg"); 
function select()
{
	msg.innerHTML = "";
    var selectOption = document.getElementById("selectOption").value;
    
    var inputField = document.getElementById("inputField");

    if(selectOption == "")
    {
        msg.innerHTML = '<div class="alert alert-warning" role="alert">PLEASE SELECT THE OPTION !!!</div>';
        btn.setAttribute("disabled",true);
        
        inputField.innerHTML = "";
        
    }
    else if(selectOption == "name")
    {
        msg.innerHTML = "";
        btn.removeAttribute("disabled");
        
       inputField.innerHTML = '<div class="mb-3"><label for="name" class="form-label">Enter Your Name To Search</label><input type="text" class="form-control" id="name" name="name" onkeyup="isChar()" required></div>';
        

    }
    else if(selectOption == "city")
    {
        msg.innerHTML = "";
        btn.removeAttribute("disabled");
        
        inputField.innerHTML = '<div class="mb-3"><label for="city" class="form-label">Enter Your City To Search</label><input type="text" class="form-control" id="city" name="city" required></div>';
    }
    else if(selectOption == "per")
    {
        msg.innerHTML = "";
        btn.removeAttribute("disabled");
        
        inputField.innerHTML = '<div class="mb-3"><label for="per" class="form-label">Enter Your Percentage To Search</label><input type="text" class="form-control" id="per" name="per" onkeyup="isDigit()" required></div>';

        
    
    }
    
    
}

function isDigit()
{
    var num = document.getElementById("per").value;
    
    if (/^\d*\.*?\d+$/.test(num))
    {
        msg.innerHTML = "";
        btn.removeAttribute("disabled");
        
        if(num > 100 || num < 0)
        {
            msg.innerHTML = '<div class="alert alert-danger" role="alert">PLEASE ENTER CORRECT PERCENTAGE !!!</div>';
            btn.setAttribute("disabled",true);
        }
    }
    else 
    {
        msg.innerHTML = '<div class="alert alert-danger" role="alert">PLEASE ENTER CORRECT PERCENTAGE !!!</div>';
        btn.setAttribute("disabled",true);
    }
}

function isChar()
{
    var name = document.getElementById("name").value;
    name = name.toLowerCase();

    var flag = true;

    for(var i = 0; i < name.length;i++)
    {
        if(name[i] == " ")
            continue;

        if(name[i] < "a" || name[i] > "z")
        {
            flag = false;        
        }
    }

    if(flag == true)
    {
        msg.innerHTML = "";
        btn.removeAttribute("disabled");
    }
    else   
    {
        msg.innerHTML = '<div class="alert alert-danger" role="alert">PLEASE ENTER CORRECT NAME !!!</div>';
        btn.setAttribute("disabled",true);
    }
}
