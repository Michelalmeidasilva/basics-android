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

## Namespaces de layout do Android

Ao editar o layout por meio do código fonte XML, vimos que existem namespaces que oferecem atributos
para editar as propriedades das Views.

Utilizamos o namespace app para chamar atributos específicos da View. Alternativa correta!
Exatamente! A partir desse namespace, podemos utilizar atributos específicos, como as constraints do
ConstraintLayout.

Para apresentar o conteúdo apenas no preview, utilizamos o tools. Alternativa correta! Isso mesmo! A
partir desse namespace, podemos desenvolver o layout apresentando informações apenas no preview.

## Constraints

layout_constraintStart_toStartOf layout_constraintStart_toEndOf Pesquisar o que é:

## Unidades de medidas

Para componentes é utilizado o DP ao invés do Pixel, pois ele calcula para cada tela a proporção
ideal.

Para fontes não é interessante utilizar o dp, por isso é utilizado o sp.

O Sp vem por padrão funcionalidades de acessibilidade.

## Views ( Recycle viewer)

Key classes Several different classes work together to build your dynamic list.

RecyclerView is the ViewGroup that contains the views corresponding to your data. It's a view
itself, so you add RecyclerView into your layout the way you would add any other UI element.

Each individual element in the list is defined by a view holder object. When the view holder is
created, it doesn't have any data associated with it. After the view holder is created, the
RecyclerView binds it to its data. You define the view holder by extending RecyclerView.ViewHolder.

The RecyclerView requests those views, and binds the views to their data, by calling methods in the
adapter. You define the adapter by extending RecyclerView.Adapter.

The layout manager arranges the individual elements in your list. You can use one of the layout
managers provided by the RecyclerView library, or you can define your own. Layout managers are all
based on the library's LayoutManager abstract class.

