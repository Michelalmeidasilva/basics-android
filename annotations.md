## Problemas com o build

Em algumas situações, o Android Studio pode apresentar problemas de compilação no projeto que, mesmo
seguindo as orientações para solução, não são resolvidos.

Se você não teve nenhum problema, sugiro apenas que salve este exercício (seja copiando o texto,
seja nos favoritos) para consultá-lo quando tiver um problema e prossiga com a próxima atividade.

Para casos como estes ou qualquer situação genérica que apresente um problema, podemos seguir os
seguintes passos que geralmente funcionam.

## Limpar e recompilar o projeto

Use o atalho Ctrl + Shift + A para abrir a opção Find Action (vai aparecer o título Enter action or
option name); Então, digite "Clean Project" até aparecer a opção com o mesmo nome e tecle Enter para
executar: essa ação vai limpar o projeto; Em seguida, Find Action novamente com o Ctrl + Shift + A e
busque a opção Rebuild Project e execute-a: nessa opção serão executadas as tasks do Gradle para
recompilar o seu projeto. Com esses passos, conseguimos resolver grande parte dos problemas, porém,
pode ser que ainda não seja o suficiente!

## Sincronizar o projeto com o Gradle

Se o problema persistir, use novamente o Find Action e tente a opção Sync Project with Gradle Files,
que vai fazer o processo de sincronização do projeto com os arquivos de configuração de build do
Gradle.

## Invalidar o cache e reiniciar o Android Studio

Se a sincronização não for o suficiente, a última alternativa é invalidar o cache. Vá no Find Action
novamente, execute a opção Invalidate Caches / Restart... e clique na opção Invalidate and Restart.

Essa opção reinicia o Android Studio, porém, além de reiniciar, no meio do processo remove todos os
arquivos gerados pela IDE e gera novamente.

Se o mesmo problema for apresentado, sugerimos que entre em contato com a gente por meio do fórum,
indicando a mensagem do problema e, se possível, enviando o projeto via GitHub para que seja
possível testar e investigar o problema.

## Diferenças entre view e view group

Hierarquia de views:

Toda view não pode ter filhos, view groups podem ter filhas.