
# Desafio! : ) 

Esse foi um projeto bem legal de fazer, obrigado pela oportunidade! Irei fazer uma versão onde pra cada endereço adicionado, ou atualização de endereço principal, será enviado um email utilizando um microserviço e creio que será uma adição interessante ao projeto! 

-> Rotas

    @PostMapping("/create-person") -> Cria uma pessoa
    Atributos a serem enviados (Exemplo):
    {
        "name": "Felipe",
        "dateOfBirth": "2002-10-19"
    } 

    @GetMapping("/persons-address") -> Retorna todas as pessoas cadastradas 
    e seus endereços principais.

    @GetMapping("/persons") -> Retorna todas as pessoas e 
    todos os endereços dela.  

    @GetMapping("/persons/{id}") -> Consulta uma pessoa

    @PutMapping("/persons/{id}") -> Atualiza uma pessoa

    @PutMapping("/{person_id}/{address_id}") -> Marca um endereço como 
    principal.

    @PostMapping("/{person_id}") -> Cria um endereço para a pessoa. 
    Atributos a serem enviados (Exemplo): 
    {
        "city": "Goiania", 
        "zipCode": "74473-811", 
        "number": "sn", 
        "streetAddress": "Rua Alvorada"
    }