package Core.Service;

import Core.Domain.Horario;
import Core.Domain.Populacao;

/**
 *
 * @author Lucas
 */
public class ReproducaoService
{

    /* Ponto de Corte para o Crossover Simples */
    public static final Integer defaultPontoCorte = 75;

    private final SelecaoService selecaoService;

    public ReproducaoService()
    {
        this.selecaoService = new SelecaoService();
    }

    public Populacao gerarNovaPopulacao(Populacao atualPopulacao)
    {
        Populacao novaPopulacao = new Populacao(FormatoService.agora(), "");
        do
        {
            Horario[] individuosPais = selecaoService.selecionarIndividuos(atualPopulacao);
            Horario[] novosIndividuos = this.gerarNovosIndividuos(individuosPais, novaPopulacao);
            novaPopulacao.pushIndividuos(novosIndividuos[0]);
            novaPopulacao.pushIndividuos(novosIndividuos[1]);
        } while (novaPopulacao.countIndividuos() < PopulacaoService.defaultIndividuosPopulacao);
        return novaPopulacao;
    }

    private Horario[] gerarNovosIndividuos(Horario[] inviduosPais, Populacao novaPopulacao)
    {
        Integer pontoCorte = ReproducaoService.defaultPontoCorte;
        Horario[] individuosFilhos = new Horario[2];

        StringBuilder strb = new StringBuilder();
        strb.append(inviduosPais[0].getHorario().substring(0, pontoCorte));
        strb.append(inviduosPais[1].getHorario().substring(pontoCorte));

        individuosFilhos[0] = new Horario(strb.toString(), novaPopulacao);

        strb = new StringBuilder();
        strb.append(inviduosPais[1].getHorario().substring(0, pontoCorte));
        strb.append(inviduosPais[0].getHorario().substring(pontoCorte));

        individuosFilhos[1] = new Horario(strb.toString(), novaPopulacao);

        return individuosFilhos;
    }

}
