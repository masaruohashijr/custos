package custos.integracao.memoria;

import java.util.ArrayList;
import java.util.List;

import custos.negocio.modelo.VPD;

public class VPDDao {
	private static List<VPD> vpds = new ArrayList<>();

	public String inserir(VPD vpd) {
		vpds.add(vpd);
		String id = vpd.getId();
		if (null == id) {
			id = String.valueOf(vpds.size() - 1);
			vpd.setId(id);
		}
		return id;
	}

	public List<VPD> listar() {
		return vpds;
	}

	public void excluir(String id) {
		VPD aRemover = null;
		for (VPD vpd : vpds) {
			if (id.equals(vpd.getId())) {
				aRemover = vpd;
				break;
			}
		}
		vpds.remove(aRemover);
	}

	public void alterar(VPD vpd) {
		String id = vpd.getId();
		vpds.remove(Integer.parseInt(id));
		vpds.add(Integer.parseInt(id), vpd);
	}
}
