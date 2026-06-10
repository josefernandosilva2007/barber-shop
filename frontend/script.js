// Função responsável por trocar as seções (páginas)
function showSection(sectionId, clickedElement) {
  // Oculta todas as sections
  const sections = document.querySelectorAll('.section');
  sections.forEach(s => s.classList.remove('active'));
  
  // Mostra a selecionada
  document.getElementById(sectionId).classList.add('active');

  // Remove o status 'active' de todos os links de navegação
  const navLinks = document.querySelectorAll('.nav-link');
  navLinks.forEach(link => link.classList.remove('active'));
  
  // Adiciona a classe ativa apenas se o elemento for passado na função
  if (clickedElement) {
      clickedElement.classList.add('active');
  }

  // Joga o scroll para cima
  window.scrollTo(0, 0);
}

// Menu sanduíche responsivo
function toggleMobileMenu() {
  const menu = document.getElementById('mobile-menu');
  menu.classList.toggle('hidden');
}

// Função simulando o envio de agendamento 
function handleBookingSubmit(e) {
  e.preventDefault();

  const name = document.getElementById('name').value;
  const phone = document.getElementById('phone').value;
  const service = document.getElementById('service').value;
  const date = document.getElementById('date').value;
  const time = document.getElementById('time').value;

  const successDiv = document.getElementById('booking-success');
  const messageP = document.getElementById('booking-message');

  // Exibe a mensagem formatada na tela
  messageP.innerHTML = `<strong>${name}</strong>, seu agendamento foi confirmado! <br>
  Serviço: <strong>${service}</strong><br>
  Data: <strong>${new Date(date).toLocaleDateString('pt-BR')}</strong><br>
  Horário: <strong>${time}</strong><br>
  Confirmaremos em breve via WhatsApp para <strong>${phone}</strong>`;

  successDiv.classList.remove('hidden');

  // Limpa o formulário
  document.getElementById('booking-form').reset();

  // Esconde o aviso após 6 segundos
  setTimeout(() => {
    successDiv.classList.add('hidden');
  }, 6000);
}

// Inicializa os ícones do Lucide após o DOM carregar
document.addEventListener("DOMContentLoaded", () => {
    setTimeout(() => {
      if (typeof lucide !== 'undefined') {
          lucide.createIcons();
      }
    }, 100);
});


function handleBookingSubmit(e) {
  e.preventDefault();

  // 1. Captura os dados do formulário exatamente como o DTO do Spring espera
  const dados = {
    cpfCliente: document.getElementById('cpf-cliente').value,
    nomeCliente: document.getElementById('name').value,
    emailCliente: document.getElementById('email-cliente').value,
    enderecoCliente: document.getElementById('endereco-cliente').value, 
    dataNascimentoCliente: document.getElementById('nascimento-cliente').value, // ADICIONADO (envia YYYY-MM-DD)
    idServico: parseInt(document.getElementById('service').value),
    cpfProfissional: "111.222.333-44", // CPF fixo do barbeiro de teste
    date: document.getElementById('date').value,
    time: document.getElementById('time').value
  };

  // 2. Faz a chamada para o seu controlador Spring Boot (/agendamento)
  fetch('http://localhost:8080/agendamento', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(dados) // Transforma o objeto JS em texto JSON
  })
  .then(response => {
    if (response.ok) {
      // SE O SPRING SALVAR NO BANCO COM SUCESSO: Mostra a caixinha verde na tela
      const successDiv = document.getElementById('booking-success');
      const messageP = document.getElementById('booking-message');

      // Pega o nome do cliente apenas para exibir no alerta visual
      const nomeCliente = document.getElementById('name').value;

      messageP.innerHTML = `<strong>${nomeCliente}</strong>, seu agendamento foi confirmado! <br>
      Data: <strong>${new Date(dados.date).toLocaleDateString('pt-BR')}</strong><br>
      Horário: <strong>${dados.time}</strong><br>
      Salvo com sucesso no banco de dados!`;

      successDiv.classList.remove('hidden');
      
      // Limpa o formulário do site
      document.getElementById('booking-form').reset();

      // Esconde o aviso de sucesso após 6 segundos
      setTimeout(() => {
        successDiv.classList.add('hidden');
      }, 6000);

    } else {
      alert('Erro do servidor: O Spring Boot recebeu a requisição mas não conseguiu salvar.');
    }
  })
  .catch(error => {
    console.error('Erro na requisição:', error);
    alert('Erro de conexão: Certifique-se de que o Spring Boot está rodando em segundo plano!');
  });
}
